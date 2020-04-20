package org.picstories.library.model.kafka.parsers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author arman.shamenov
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractTask {
    UUID id = UUID.randomUUID();
}
