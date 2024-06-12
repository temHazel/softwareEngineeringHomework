import java.util.function.Supplier;

public class JsonTreeFactory implements ContainerFactory {
    private final Supplier<Icon> iconSupplier;

    public JsonTreeFactory(Supplier<Icon> iconSupplier) {
        this.iconSupplier = iconSupplier;
    }

    @Override
    public Container createContainer() {
        Component style = new JsonTreeStyle();
        Icon icon = iconSupplier.get();
        return new Container(style, icon);
    }
}
