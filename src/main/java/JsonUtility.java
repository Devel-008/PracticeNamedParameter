/*


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonUtility {
    static ObjectMapper objectMapper = new ObjectMapper();
    */
/**
     * Look at the json schema and convert the list to json array
     *
     * @param data
     * @param jsonSchema
     * @return
     *//*

    static Logger logger = LoggerFactory.getLogger(JsonUtility.class);


    public static JsonNode convertToJson(List<Map<String, Object>> data, JsonNode jsonSchema) throws Exception {
        logger.info("Executing :: JsonUtility.convertToJson");
        //this method will firstly convert list data into json than validate it against given json schema
        ObjectNode objectNode = objectMapper.createObjectNode();
        for (Map<String, Object> map : data) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    objectNode.putNull(key);
                } else if (value instanceof String) {
                    objectNode.put(key, (String) value);
                } else if (value instanceof Boolean) {
                    objectNode.put(key, (Boolean) value);
                } else if (value instanceof Integer) {
                    objectNode.put(key, (Integer) value);
                } else if (value instanceof Map) {
                    JsonNode nestedJsonNode = convertMapToJsonNode((Map<String, Object>) value, objectMapper);
                    objectNode.set(key, nestedJsonNode);
                } else if (value instanceof List) {
                    JsonNode nestedJsonNode = convertListToJsonNode((List<Map<String, Object>>) value, objectMapper);
                    objectNode.set(key, nestedJsonNode);
                } else {
                    throw new IllegalArgumentException("Unsupported value type: " + value.getClass());
                }
            }
        }
        if(validateJsonAgainstSchema(objectNode,jsonSchema)){
            //if json validate then write the output json in file
            FileWriter fileWriter = new FileWriter("src/test/resources/data.json");
            fileWriter.write(objectNode.toPrettyString());
            fileWriter.close();
            System.out.println("Data Saved");
        }
        logger.info("Exiting :: JsonUtility.convertToJson");
        return objectMapper.readTree(objectNode.toString());
    }
    private static JsonNode convertMapToJsonNode(Map<String, Object> map, ObjectMapper objectMapper) {
        //it is to convert map into json
        ObjectNode objectNode = objectMapper.createObjectNode();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                objectNode.put(key, (String) value);
            } else if (value instanceof Integer) {
                objectNode.put(key, (Integer) value);
            } else if (value instanceof Boolean) {
                objectNode.put(key, (Boolean) value);
            } else  {
                JsonNode nestedJsonNode = convertMapToJsonNode((Map<String, Object>) value, objectMapper);
                objectNode.set(key, nestedJsonNode);
            }
        }
        return objectNode;
    }

    private static JsonNode convertListToJsonNode(List<Map<String, Object>> list, ObjectMapper objectMapper) {
        //it is to convert list into json
        ArrayNode arrayNode = objectMapper.createArrayNode();
        for (Map<String, Object> map : list) {
            JsonNode nestedJsonNode = convertMapToJsonNode(map, objectMapper);
            arrayNode.add(nestedJsonNode);
        }
        return arrayNode;
    }
    private static boolean validateJsonAgainstSchema(JsonNode jsonData, JsonNode schemaData) throws Exception {
        logger.info("Executing :: JsonUtility.convertToJson");
        if (schemaData.isEmpty()){
            throw new Exception("Schema Empty");
        }
        // Validate JSON against schema
        if (isValidJson(jsonData, schemaData)) {
            System.out.println("JSON is valid against schema.");
            logger.info("Exiting :: JsonUtility.convertToJson");
            return true;
        } else {
            logger.info("Exiting because of Exception :: JsonUtility.convertToJson");
            throw new Exception("JSON is invalid against the schema.");
        }

    }

    private static boolean isValidJson(JsonNode jsonNode, JsonNode schemaNode) throws Exception {
        //check the type and help to validate the given data type
        if (schemaNode.has("type")) {
            String type = schemaNode.get("type").asText();
            switch (type) {
                //when the type is object
                case "object":
                    if (!jsonNode.isObject()) {
                        throw new Exception("Invalid type: object expected.");
                    }
                    if (schemaNode.has("required")) {
                        //checks for required elements
                        ArrayNode requiredFields = (ArrayNode) schemaNode.get("required");
                        for (JsonNode requiredField : requiredFields) {
                            //get required field and check it
                            if (!jsonNode.has(requiredField.asText())) {
                                throw new Exception("Missing required field: " + requiredField.asText());
                            }
                        }
                    }

                    break;
                case "array":
                    //for array validation
                    if (!jsonNode.isArray()) {
                        throw new Exception("Invalid type: array expected.");
                    }
                    if (schemaNode.has("items")) {
                        JsonNode itemsNode = schemaNode.get("items");
                        for (JsonNode itemNode : jsonNode) {
                            if (!isValidJson(itemNode, itemsNode)) {
                                return false;
                            }
                        }
                    }
                    break;
                case "string":
                    if (!jsonNode.isTextual()) {
                        throw new Exception("Invalid type: string expected.");
                    }
                    break;
                case "integer":
                    if (!jsonNode.isNumber()) {
                        throw new Exception("Invalid type: integer expected.");
                    }
                    break;
                case "boolean":
                    if (!jsonNode.isBoolean()) {
                        throw new Exception("Invalid type: boolean expected.");
                    }
                    break;
                default:
                    throw new Exception("Invalid type: " + type);
            }
            //check the given properties in json schema are present in given json or not and if the schema does not have the property name it will return false
            if (schemaNode.has("properties")) {
                Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> field = fields.next();
                    if (!schemaNode.get("properties").has(field.getKey())) {
                        return false;
                    }
                    //recursive call to the method. we need it to handle nested structure of the schema
                    if (!isValidJson(field.getValue(), schemaNode.get("properties").get(field.getKey()))) {
                        return false;
                    }
                }
            }
        }
        //when pass all validation
        return true;
    }




}
*/
