public class ThirdAction extends SecondAction implements FirstAction{
    @Override
    public void add(){
        saveObject();
    }
    @Override
    public void delete(){
        deleteObject();
    }

}
