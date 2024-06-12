import java.util.function.Supplier;

public class RectangleFactory implements ContainerFactory {
    private final Supplier<Icon> iconSupplier;

    public RectangleFactory(Supplier<Icon> iconSupplier) {
        this.iconSupplier = iconSupplier;
    }

    @Override
    public Container createContainer() {
        Component style = new RectangleStyle();
        Icon icon = iconSupplier.get();
        return new Container(style, icon);
    }
}
