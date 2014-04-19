package com.hudsonhui.wunderlisttoastrid;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hudsonhui.wunderlisttoastrid.astrid.Astrid;
import com.hudsonhui.wunderlisttoastrid.astrid.MetaData;
import com.hudsonhui.wunderlisttoastrid.astrid.TagData;
import com.hudsonhui.wunderlisttoastrid.astrid.Task;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App {
    
    private static String WUNDERLIST_JSON_FILE = "wunderlist.json";
    private static String ASTRID_XML_FILE = "astrid.xml";
    
    private static String removeFirstAndLast(String str) {
        if (str.length() >= 2 && str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, JAXBException {
        // read wunderlist json
        StringBuilder sb = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(WUNDERLIST_JSON_FILE)) {
            try (InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8")) {
                try (BufferedReader reader = new BufferedReader(streamReader)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        sb.append(String.format("%n"));
                    }
                }
            }
        }
        
        System.out.println("------- Json File -------");
        System.out.println(sb.toString());
        
        // parse json
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(sb.toString());
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray listJsonArray = jsonObject.getAsJsonArray("lists");
        JsonArray taskJsonArray = jsonObject.getAsJsonArray("tasks");
        
        // convert to astrid models
        Map<String, TagData> tagDataMap = new HashMap<>();
        List<TagData> tagDataList = new ArrayList<>();
        for (int i = 0; i < listJsonArray.size(); i++) {
            JsonElement listJsonElement = listJsonArray.get(i);
            JsonObject listJsonObject = listJsonElement.getAsJsonObject();
            // title
            String listName = listJsonObject.get("title").toString();
            listName = removeFirstAndLast(listName);
            TagData tagData = new TagData();
            tagData.setName(listName);
            // list_id
            String listId = listJsonObject.get("id").toString();
            listId = removeFirstAndLast(listId);
            
            tagDataMap.put(listId, tagData);
            tagDataList.add(tagData);
        }
        List<Task> taskList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < taskJsonArray.size(); i++) {
            JsonElement taskJsonElement = taskJsonArray.get(i);
            JsonObject taskJsonObject = taskJsonElement.getAsJsonObject();
            if (!taskJsonObject.has("completed_at") && !taskJsonObject.has("parent_id")) {
                Task task = new Task();
                // title
                String taskTitle = taskJsonObject.get("title").toString();
                taskTitle = removeFirstAndLast(taskTitle);
                task.setTitle(taskTitle);
                // notes
                if (taskJsonObject.has("note")) {
                    String taskNotes = taskJsonObject.get("note").toString();
                    taskNotes = removeFirstAndLast(taskNotes);
                    taskNotes = StringUtils.replace(taskNotes, "\\n", String.format("%n"));
                    taskNotes = StringUtils.replace(taskNotes, "\\t", " ");
                    task.setNotes(taskNotes);
                }
                // due_date
                if (taskJsonObject.has("due_date")) {
                    String taskDueDate = taskJsonObject.get("due_date").toString();
                    taskDueDate = removeFirstAndLast(taskDueDate);
                    Date date = dateFormat.parse(taskDueDate);
                    task.setDueDate(date);
                }
                // list_id
                if (taskJsonObject.has("list_id")) {
                    String listId = taskJsonObject.get("list_id").toString();
                    listId = removeFirstAndLast(listId);
                    TagData tagData = tagDataMap.get(listId);
                    MetaData metadata = new MetaData();
                    metadata.set(task, tagData);
                }
                // recurrence_type
                if (taskJsonObject.has("recurrence_type")) {
                    String recurrenceType = taskJsonObject.get("recurrence_type").toString();
                    recurrenceType = removeFirstAndLast(recurrenceType);
                    String recurrenceCount = taskJsonObject.get("recurrence_count").toString();
                    recurrenceCount = removeFirstAndLast(recurrenceCount);
                    if (recurrenceCount.length() == 0) {
                        throw new RuntimeException("recurrence_count is empty");
                    }
                    int recurrenceCountInt = Integer.parseInt(recurrenceCount, 10);
                    if ("day".equals(recurrenceType)) {
                        task.setRecurrence(Task.RECURRENCE_FREQ_DAILY, recurrenceCountInt);
                    } else if ("week".equals(recurrenceType)) {
                        task.setRecurrence(Task.RECURRENCE_FREQ_WEEKLY, recurrenceCountInt);
                    } else if ("month".equals(recurrenceType)) {
                        task.setRecurrence(Task.RECURRENCE_FREQ_MONTHLY, recurrenceCountInt);
                    } else if ("year".equals(recurrenceType)) {
                        task.setRecurrence(Task.RECURRENCE_FREQ_YEARLY, recurrenceCountInt);
                    }
                }
                // starred
                if (taskJsonObject.has("starred")) {
                    String starred = taskJsonObject.get("starred").toString();
                    starred = removeFirstAndLast(starred);
                    if (!"false".equals(starred)) {
                        task.setImportance("1");
                    }
                }
                
                taskList.add(task);
            }
        }
        
        // convert to xml file
        System.out.println("------- XML File -------");
        Astrid astrid = new Astrid();
        astrid.setTasks(taskList);
        astrid.setTagDatas(tagDataList);
        
        JAXBContext context = JAXBContext.newInstance(Astrid.class);
        Marshaller marshaller = context.createMarshaller();
        
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        marshaller.marshal(astrid, out);
        
        marshaller.marshal(astrid, new File(ASTRID_XML_FILE));
    }

}
