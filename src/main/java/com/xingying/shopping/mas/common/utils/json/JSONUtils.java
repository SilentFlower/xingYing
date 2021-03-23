package com.xingying.shopping.mas.common.utils.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * json处理工具
 *
 * @author zhaoweihao
 * @since 2019-10-16
 */
public class JSONUtils {

    private JSONUtils() {}

    private static ObjectMapper jacksonMapper;

    static {
        jacksonMapper = new ObjectMapper()
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(JsonParser.Feature.IGNORE_UNDEFINED, true)
                .configure(SerializationFeature.INDENT_OUTPUT, true) // 格式化使json更可读,生产环境建议注释
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addSerializer(LocalTime.class, new LocalTimeSerializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addDeserializer(LocalTime.class, new LocalTimeDeserializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        jacksonMapper.registerModule(module);
    }


    public static String toString(Object o) {
        if (o instanceof String) return (String) o;
        return wrapException(() -> jacksonMapper.writeValueAsString(o));
    }

    public static byte[] toBytes(Object o) {
        return wrapException(() -> jacksonMapper.writeValueAsBytes(o));
    }

    public static void output(File resultFile, Object o) throws IOException {
        jacksonMapper.writeValue(resultFile, o);
    }

    public static void output(OutputStream out, Object o) throws IOException {
        jacksonMapper.writeValue(out, o);
    }

    public static void output(Writer writer, Object o) throws IOException {
        jacksonMapper.writeValue(writer, o);
    }

    public static <T> T toBean(String source, Class<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }

    public static <T> T toBean(File source, Class<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }

    public static <T> T toBean(URL source, Class<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }

    public static <T> T toBean(Reader source, Class<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }

    public static <T> T toBean(InputStream source, Class<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }

    public static <T> T toBean(byte[] source, Class<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }

    public static <T> T toBean(String source, JavaTypeReference<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }

    public static <T> T toBean(File source, JavaTypeReference<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }

    public static <T> T toBean(URL source, JavaTypeReference<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }


    public static <T> T toBean(Reader source, JavaTypeReference<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }

    public static <T> T toBean(InputStream source, JavaTypeReference<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }

    public static <T> T toBean(byte[] source, JavaTypeReference<T> dest) {
        return wrapException(() -> jacksonMapper.readValue(source, dest));
    }

    public static JsonNode toJsonNode(String source) {
        return wrapException(() -> jacksonMapper.readTree(source));
    }

    public static JsonNode toJsonNode(byte[] source) {
        return wrapException(() -> jacksonMapper.readTree(source));
    }

    public static JsonNode toJsonNode(File source) {
        return wrapException(() -> jacksonMapper.readTree(source));
    }

    public static JsonNode toJsonNode(InputStream source) {
        return wrapException(() -> jacksonMapper.readTree(source));
    }

    public static JsonNode toJsonNode(Reader source) {
        return wrapException(() -> jacksonMapper.readTree(source));
    }

    public static JsonNode toJsonNode(URL source) {
        return wrapException(() -> jacksonMapper.readTree(source));
    }

    public static ObjectMapper getObjectMapper() {
        return jacksonMapper.copy();
    }

    public static JsonNodeFactory getNodeFactory() {
        return jacksonMapper.getNodeFactory();
    }

    private static <T> T wrapException(supplierWithException<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FunctionalInterface
    private interface supplierWithException<T> {
        T get() throws Exception;
    }

    private static class LocalDateSerializer extends JsonSerializer<LocalDate> {

        private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @Override
        public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeString(dateFormatter.format(value));
        }
    }

    private static class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

        private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        @Override
        public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeString(dateTimeFormatter.format(value));
        }

    }

    private static class LocalTimeSerializer extends JsonSerializer<LocalTime> {

        private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        @Override
        public void serialize(LocalTime value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeString(timeFormatter.format(value));
        }

    }

    private static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

        private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @Override
        public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String value = jsonParser.getValueAsString();
            return LocalDate.parse(value, dateFormatter);
        }
    }

    private static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

        private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        @Override
        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String value = jsonParser.getValueAsString();
            return LocalDateTime.parse(value, dateTimeFormatter);
        }
    }

    private static class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {

        private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        @Override
        public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String value = jsonParser.getValueAsString();
            return LocalTime.parse(value, timeFormatter);
        }
    }




}
