package org.hildan.fxgson.adapters.properties.primitives;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

import com.google.gson.TypeAdapter;

/**
 * An implementation of {@link PrimitivePropertyTypeAdapter} for JavaFX {@link LongProperty}. It serializes the long
 * value of the property instead of the property itself.
 */
public class LongPropertyTypeAdapter extends PrimitivePropertyTypeAdapter<Long, LongProperty> {

    /**
     * Creates a new LongPropertyTypeAdapter.
     *
     * @param crashOnNullValue
     *         if true, this adapter will throw {@link NullPrimitiveException} when reading a null value. If false, this
     *         adapter will create a new simple property using the default constructor instead.
     * @param delegate
     *         a delegate adapter to use for the inner value of the property
     */
    public LongPropertyTypeAdapter(boolean crashOnNullValue, TypeAdapter<Long> delegate) {
        super(crashOnNullValue, delegate);
    }

    @Override
    protected Long extractPrimitiveValue(LongProperty property) {
        return property.get();
    }

    @Override
    protected LongProperty createDefaultProperty() {
        return new SimpleLongProperty();
    }

    @Override
    protected LongProperty wrapNonNullPrimitiveValue(Long deserializedValue) {
        return new SimpleLongProperty(deserializedValue);
    }
}