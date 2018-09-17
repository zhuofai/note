package cn.itcast.reflect2;

public class SecretPerson {
    private String name;
    private int age;

    private SecretPerson() {

    }

    private SecretPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //整理文件
    public void manageFile(){
        System.out.println(name+"正在整理文件");
    }
    //陪老板旅游
    private void travelWithBoss(String bossName,String destination,String something){
        System.out.println(name+"正在陪"+ bossName+"在"+ destination+"开心的"+ something);
    }

}
