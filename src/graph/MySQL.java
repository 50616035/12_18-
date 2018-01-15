package graph;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	// JDBC�h���C�o�̓o�^
    String driver;
    // �f�[�^�x�[�X�̎w��
    String server, dbname, url, user, password;
    Connection con;
    Statement stmt;
    ResultSet rs;
	public MySQL() {//�R���X�g���N�^�ŃC���X�^���X�ɐڑ�����i�e�[�u���ɐڑ��j
		this.driver  = "org.gjt.mm.mysql.Driver";
		this.server  = "ms000.sist.ac.jp";      // MySQL�T�[�o ( IP �܂��� �z�X�g�� );
		this.dbname  = "java2017";         // �f�[�^�x�[�X��;
		this.url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";
		this.user = "java2017";         // �f�[�^�x�[�X�쐬���[�U��;
		this.password  = "java2017";     // �f�[�^�x�[�X�쐬���[�U�p�X���[�h;

		try {//��O����
			this.con = DriverManager.getConnection(url, user, password);
			this.stmt = con.createStatement ();
		} catch (SQLException e) {//��O�����������ꍇcatch��������
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName (driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
public ResultSet selectAll() {//�e�[�u������������o��
	String sql = "SELECT * FROM `50616035`";//�o�b�N�X���b�V�����厖
	ResultSet rs = null;
	try {
		rs = stmt.executeQuery (sql);//sql�������s�����
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  //try catch�ň͂�
	return rs;

}
public void close() {//�f�[�u������ؒf
	try {
		rs.close();
		stmt.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}


}
