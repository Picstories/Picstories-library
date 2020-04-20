package org.picstories.library.jackson;

import org.jetbrains.annotations.Nullable;
import org.picstories.library.exceptions.SerializationException;

import java.io.InputStream;

/**
 * @author arman.shamenov
 */
public interface PicstoriesSerializer {
    @Nullable
    byte[] serialize(@Nullable Object object) throws SerializationException;

    @Nullable
    String serializeToString(@Nullable Object object) throws SerializationException;

    @Nullable
    <T> T deserialize(@Nullable String data, Class<T> responseType) throws SerializationException;

    @Nullable
    <T> T deserialize(@Nullable InputStream data, Class<T> responseType) throws SerializationException;

    @Nullable
    <T> T deserialize(@Nullable byte[] data, Class<T> responseType) throws SerializationException;
}
