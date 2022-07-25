package testRegex;

public class CongAn {
    public void capCCCD(ICapCanCuocCD capCCCD){
        if (capCCCD.getCMND()==null){
            System.out.println("Ve lay cmnd");
            return;
        }
        if (capCCCD.getSoHK()==null){
            System.out.println("Ve lay so HK");
            return;
        }
        System.out.println("Dang xac minh giay to");
        System.out.println("Cap can cuoc thanh cong");

    }
}
