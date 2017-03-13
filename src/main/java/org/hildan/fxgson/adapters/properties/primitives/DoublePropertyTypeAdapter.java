package org.hildan.fxgson.adapters.properties.primitives;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import com.google.gson.TypeAdapter;

/**
 * An implementation of {@link PrimitivePropertyTypeAdapter} for JavaFX {@link DoubleProperty}. It serializes the double
 * value of the property instead of the property itself.
 */
public class DoublePropertyTypeAdapter extends PrimitivePropertyTypeAdapter<Double, DoubleProperty> {

    /**
     * Creates a new DoublePropertyTypeAdapter.
     *
     * @param crashOnNullValue
     *         if true, this adapter will throw {@link NullPrimitiveException} when reading a null value. If false, this
     *         adapter will call {@link #createDefaultProperty()} instead.
     * @param delegate
     *         a delegate adapter to use for the inner value of the property
     */
    public DoublePropertyTypeAdapter(boolean crashOnNullValue, TypeAdapter<Double> delegate) {
        super(crashOnNullValue, delegate);
    }

    @Override
    protected Double extractPrimitiveValue(DoubleProperty property) {
        return property.get();
    }

    @Override
    protected DoubleProperty createDefaultProperty() {
        return new SimpleDoubleProperty();
    }

    @Override
    protected DoubleProperty wrapNonNullPrimitiveValue(Double deserializedValue) {
        return new SimpleDoubleProperty(deserializedValue);
    }
}