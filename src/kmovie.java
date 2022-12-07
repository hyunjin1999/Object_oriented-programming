import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class kmovie extends Hallyu implements HallyuInterface{
    @Override
    public void printInfo(String name) {
        // 1. 파일 읽기
        FileIO fileread = new FileIO();
        List<List<String>> csvList;
        csvList = fileread.fileRead("k-movie");

        //2. 이름으로 정보 찾기
        boolean isTrue = false;
        for (List<String> strings : csvList) {
            if (Objects.equals(strings.get(0), name)) {
                System.out.println(strings);
                isTrue = true;
            }
        }
        System.out.println("");
        if(!isTrue) { System.out.println("찾는 정보가 없습니다. 직접 추가해 주세요.\n"); }

    }

    @Override
    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("감독명을 입력해주세요.");
        String name = sc.next();
        System.out.println("제목을 입력해주세요.");
        String title = sc.next();
        System.out.println("장르를 입력해주세요.");
        String genre = sc.next();

        FileIO filewrite = new FileIO();
        filewrite.fileWrite("k-movie",name, title, genre);
        //파일에 쓰기

        System.out.println("정보 입력이 완료되었습니다.");
    }
}
