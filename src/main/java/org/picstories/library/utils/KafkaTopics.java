package org.picstories.library.utils;

/**
 * @author arman.shamenov
 */
public class KafkaTopics {
    private KafkaTopics() {
        // no instance
    }
    
    public static final String KAFKA_UPDATE_COMIC_TOPIC = "update-comic-task";
    public static final String KAFKA_PARSE_COMIC_TASK = "parse-comic-task";
}
