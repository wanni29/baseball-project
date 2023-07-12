package test;

public class lab_testing {

    public static void main(String[] args) {

//        String request = "선수등록?teamId=1&name=이대호&position=1루수";
//        String[] parts = request.split("\\?");

//        String playerStatus = parts[1];
//        System.out.println(playerStatus);

//        String[] partss = playerStatus.split("&");
//        System.out.println(partss.length);
//        System.out.println(partss[0]);
//        System.out.println(partss[1]);
//        System.out.println(partss[2]);
//
//        System.out.println("===============================");
//
//        String[] partss1 = partss[0].split("=");
//        String[] partss2 = partss[1].split("=");
//        String[] partss3 = partss[2].split("=");
//
//        System.out.println("===============================");
//
//        System.out.println(partss1[1]);
//        System.out.println(partss2[1]);
//        System.out.println(partss3[1]);
//
//        System.out.println("===============================");
//
//
//        int a = Integer.parseInt(partss1[1]);
//        System.out.println(a);
//        String b = partss2[1];
//        String c= partss3[1];

        // 소스코드 추출
        String request = "선수등록?teamId=1&name=이대호&position=1루수";
        String[] parts = request.split("\\?");
        String playerStatus = parts[1];
        String[] partss = playerStatus.split("&");
        String[] partss1 = partss[0].split("=");
        String[] partss2 = partss[1].split("=");
        String[] partss3 = partss[2].split("=");

        // 원하는 값 추출 완료
        int team_id = Integer.parseInt(partss1[1]);
        String name = partss2[1];
        String position = partss3[1];

        // 테스팅 완료


    }
}
