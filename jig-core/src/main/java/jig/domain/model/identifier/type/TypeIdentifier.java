package jig.domain.model.identifier.type;

import jig.domain.model.identifier.namespace.PackageIdentifier;

import java.util.Objects;

public class TypeIdentifier {

    String value;

    public TypeIdentifier(Class<?> clz) {
        this(clz.getName());
    }

    public TypeIdentifier(String value) {
        this.value = value.replace('/', '.');
    }

    public String fullQualifiedName() {
        return format(value -> value);
    }

    public String asSimpleText() {
        return hasPackage() ? format(value -> value.substring(value.lastIndexOf(".") + 1)) : value;
    }

    public String format(TypeIdentifierFormatter formatter) {
        return formatter.format(value);
    }

    private boolean hasPackage() {
        return value.contains(".");
    }

    public PackageIdentifier packageIdentifier() {
        if (!hasPackage()) {
            return PackageIdentifier.defaultPackage();
        }
        return new PackageIdentifier(value.substring(0, value.lastIndexOf(".")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeIdentifier that = (TypeIdentifier) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}