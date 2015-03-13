package autojson;

import javax.lang.model.element.PackageElement;
import javax.lang.model.element.QualifiedNameable;

final class Elements {

    private Elements() {
    }

    public static String getQualifiedNameWithoutPackage(PackageElement pkg, QualifiedNameable element) {
        String name = element.getQualifiedName().toString();
        if (!pkg.isUnnamed()) {
            name = name.substring(pkg.getQualifiedName().length() + 1);
        }
        return name;
    }

}
