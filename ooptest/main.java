package ooptest;

public class main {

    public static void main(String[] args) {
        Customer vc = new VIPCustomer(12345, "noname");
        // 자바의 모든 메서드는 가상 메서드이다.
        // 가상 메서드 테이블에서 해당 메서드에 대한 address를 호출.
        // 상속받은 클래스의 메서드를 오버로딩한 경우 재정의한 메서드가 호출된다.
        int i = vc.calcPrice(1000);
        System.out.println("i = " + i);



    }
}
