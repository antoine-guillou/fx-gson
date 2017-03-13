package org.hildan.fxgson.adapters.properties;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import com.google.gson.TypeAdapter;
import org.jetbrains.annotations.NotNull;

/**
 * A basic {@link TypeAdapter} for JavaFX {@link Property}. It serializes the object inside the property instead of the
 * property itself.
 */
public class ObjectPropertyTypeAdapter<T> extends PropertyTypeAdapter<T, Property<T>> {

    /**
     * Creates a new ObjectPropertyTypeAdapter.
     *
     * @param delegate
     *         a delegate adapter to use for the inner object value of the property
     */
    public ObjectPropertyTypeAdapter(TypeAdapter<T> delegate) {
        super(delegate);
    }

    @NotNull
    @Override
    protected Property<T> createProperty(T deserializedValue) {
        return new SimpleObjectProperty<>(deserializedValue);
    }
}