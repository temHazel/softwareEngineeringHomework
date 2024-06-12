public class ContainerDirector {
    private ContainerFactory factory;
    public ContainerDirector(ContainerFactory factory){
        this.factory = factory;
    }
    public Container getProduct(){
        return this.factory.createContainer();
    }
}
