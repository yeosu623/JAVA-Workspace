import java.sql.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.sql.Types.NULL;

public class JDBCTest {
    public static void main(String[] args) {
        int menu = -999;
        int i;
        int sid, deptno, advisor;
        float grade;
        String sname, gen, addr, inputString, temp;
        String[] inputStringArray;
        Date birthdate;
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        PreparedStatement query;
        ResultSet rset;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException : " + e.getMessage());
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "scott", "tiger");

            while(menu != 6) {
                System.out.println("Menu(1:학생 추가, 2:학생 삭제, 3:학생 수정, 4:학생 검색, 5:학과 출력, 6:종료)");
                menu = sc.nextInt();

                switch(menu) {
                    case 1:
                        System.out.println("삽입할 학생 정보 입력(sid,sname,deptno,advisor,gen,addr,birthdate,grade)");
                        System.out.println("입력시에는 쉼표(,)를 기준으로 속성을 구분하고, 한 줄에 전부 작성합니다.");
                        System.out.println("속성을 입력하지 않으려면 바로 다음 쉼표를 작성합니다. ex) 10,,,30,M");
                        inputString = sc.next();
                        inputStringArray = inputString.split(",", -1);

                        query = conn.prepareStatement("insert into student values (?, ?, ?, ?, ?, ?, ?, ?)");

                        for(i = 1; i <= 8; i++) {
                            temp = inputStringArray[i-1];
                            if(temp.isEmpty()) query.setNull(i, NULL);
                            else {
                                switch(i) {
                                    case 1: query.setInt(1, Integer.parseInt(temp)); break;
                                    case 2: query.setString(2, temp); break;
                                    case 3: query.setInt(3, Integer.parseInt(temp)); break;
                                    case 4: query.setInt(4, Integer.parseInt(temp)); break;
                                    case 5: query.setString(5, temp); break;
                                    case 6: query.setString(6, temp); break;
                                    case 7: query.setDate(7, Date.valueOf(temp)); break;
                                    case 8: query.setFloat(8, Float.parseFloat(temp)); break;
                                }
                            }
                        }
                        rset = query.executeQuery();
                        break;
                    case 2:
                        System.out.print("삭제할 학생의 학번 입력 = ");
                        sid = sc.nextInt();

                        query = conn.prepareStatement("delete from student where sid = ?");
                        query.setInt(1, sid);
                        rset = query.executeQuery();
                        break;
                    case 3:
                        System.out.print("수정할 학생의 학번 입력 = ");
                        sid = sc.nextInt();

                        query = conn.prepareStatement("select * from student where sid = ?");
                        query.setInt(1, sid);
                        rset = query.executeQuery();
                        rset.next();
                        System.out.println("현재 속성 : " + rset.getString("sname") + "," +
                                                        rset.getInt("deptno") + "," +
                                                        rset.getInt("advisor") + "," +
                                                        rset.getString("gen") + "," +
                                                        rset.getString("addr") + "," +
                                                        rset.getDate("birthdate") + "," +
                                                        rset.getFloat("grade"));

                        System.out.println("새로운 학생 정보 입력(sname,deptno,advisor,gen,addr,birthdate,grade)");
                        System.out.println("입력시에는 쉼표(,)를 기준으로 속성을 구분하고, 한 줄에 전부 작성합니다.");
                        System.out.println("속성을 입력하지 않으려면 바로 다음 쉼표를 작성합니다. ex) 10,,,30,M");
                        inputString = sc.next();
                        inputStringArray = inputString.split(",", -1);

                        query = conn.prepareStatement("update student set sname=?, deptno=?, advisor=?, gen=?, addr=?, birthdate=?, grade=? where sid=?");

                        for(i = 1; i <= 7; i++) {
                            temp = inputStringArray[i-1];
                            if(temp.isEmpty()) query.setNull(i, NULL);
                            else {
                                switch(i) {
                                    case 1: query.setString(1, temp); break;
                                    case 2: query.setInt(2, Integer.parseInt(temp)); break;
                                    case 3: query.setInt(3, Integer.parseInt(temp)); break;
                                    case 4: query.setString(4, temp); break;
                                    case 5: query.setString(5, temp); break;
                                    case 6: query.setDate(6, Date.valueOf(temp)); break;
                                    case 7: query.setFloat(7, Float.parseFloat(temp)); break;
                                }
                            }
                        }
                        query.setInt(8, sid);

                        rset = query.executeQuery();
                        break;
                    case 4:
                        System.out.print("검색할 학생의 학번 입력");
                        sid = sc.nextInt();

                        query = conn.prepareStatement("select * from student where sid = ?");
                        query.setInt(1, sid);
                        rset = query.executeQuery();
                        rset.next();
                        System.out.println("검색한 학생의 속성 : " + rset.getString("sname") + "," +
                                                                  rset.getInt("deptno") + "," +
                                                                  rset.getInt("advisor") + "," +
                                                                  rset.getString("gen") + "," +
                                                                  rset.getString("addr") + "," +
                                                                  rset.getDate("birthdate") + "," +
                                                                  rset.getFloat("grade"));
                        break;
                    case 5:
                        System.out.print("정보를 보고싶은 학과 번호 입력 = ");
                        deptno = sc.nextInt();

                        query = conn.prepareStatement("SELECT sid, sname, dname, pname " +
                                                          "FROM student s, department d, professor p " +
                                                          "WHERE s.deptno = ? " +
                                                          "AND s.deptno = d.deptno " +
                                                          "AND s.advisor = p.pid(+) " +
                                                          "ORDER BY sid");
                        query.setInt(1, deptno);
                        rset = query.executeQuery();
                        System.out.println("sid  \tsname\tdname\t\tpname");
                        while(rset.next()) {
                            System.out.println(rset.getInt("sid") + "\t" +
                                               rset.getString("sname") + "\t" +
                                               rset.getString("dname") + "\t" +
                                               rset.getString("pname"));
                        }
                        break;
                    case 6:
                        System.out.println("Program Exit.");
                        break;
                    default:
                        System.out.println("Wrong Menu.");
                }
            }
        } catch (SQLException sqle) {
            System.err.println("SQLException : " + sqle);
        }
    }
}
