/*
[주석 1: 과제 설명]

객체지향프로그래밍 평가과제(배점 25점)
학과: 컴퓨터전자시스템공학부
학번: 201800377
이름: 강현진

과제 주제: k-pop, k-drama, k-movie 정보 조회 및 출력하는 프로그램 구현
 */


// 다형성(상속, 인터페이스)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        enum Types{K_POP_REF, K_POP_ADD, K_DRAMA_REF, K_DRAMA_ADD, K_MOVIE_REF, K_MOVIE_ADD}  // 주석6 참조 타입(열거타입)
        Scanner sc = new Scanner(System.in);
        Hallyu manager = new Hallyu(); // 주석5: 다형성

        int choice;
        String userName;

        System.out.println("사용자 이름을 입력하세요.");
        userName = sc.next();
        if(!manager.isTrueUser(userName)){
            System.out.println("등록된 사용자가 아닙니다. 관리자에게 문의하세요");
            System.exit(0);
        }
        System.out.println("안녕하세요 "+manager.getName()+"님");
        int count = 0;
        while(true) {
            System.out.println("수행할 카테고리를 번호로만 선택하세요.");
            System.out.println("-------------------------------");
            int temp=1;
            for(Types type: Types.values()){
                System.out.print(temp++ + ". ");
                System.out.println(type);
            }

            choice = sc.nextInt();
            String name;
            User user = new User();
            switch (choice) {

                case 1 -> {
                    count = 0;
                    System.out.println("k-pop 정보조회를 선택하셨습니다.");
                    System.out.println("정보조회를 원하는 가수(그룹)명을 입력하세요.");
                    name = sc.next();
                    kpop pop = new kpop();
                    user.userPrint(pop, name); // 주석5: 다형성
                }
                case 2 -> {
                    count = 0;
                    System.out.println("k-pop 정보추가를 선택하셨습니다.");

                    kpop pop = new kpop();
                    user.userInput(pop);
                }
                case 3 -> {
                    count = 0;
                    System.out.println("k-drama 정보조회를 선택하셨습니다.");
                    System.out.println("정보조회를 원하는 연출자 이름을 입력하세요.");
                    kdrama drama = new kdrama();
                    name = sc.next();
                    user.userPrint(drama, name);
                }
                case 4 -> {
                    count = 0;
                    System.out.println("k-drama 정보추가를 선택하셨습니다.");
                    kdrama drama = new kdrama();
                    user.userInput(drama);
                }
                case 5 -> {
                    count = 0;
                    System.out.println("k-movie 정보조회를 선택하셨습니다.");
                    System.out.println("정보조회를 원하는 감독이름을 입력하세요.");
                    kmovie movie = new kmovie();
                    name = sc.next();
                    user.userPrint(movie, name);
                }
                case 6 -> {
                    count = 0;
                    System.out.println("k-movie 정보추가를 선택하셨습니다.");

                    kmovie movie = new kmovie();
                    user.userInput(movie);
                }
                default -> {
                    if((++count)==3) {
                        System.out.println("사용방법을 다시 확인해주세요. 프로그램을 종료합니다.");
                        System.exit(0);
                    System.out.println("올바르지 않은 선택합니다. 1번~6번 중 선택해주세요.\n");
                    }
                }
            }
        }
    }
}