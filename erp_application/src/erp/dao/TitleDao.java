package erp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import erp.dto.Title;
import erp.jdbc.DBCon;
import erp.jdbc.JdbcUtil;

public class TitleDao implements Dao<Title>{
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	private static final TitleDao instance = new TitleDao();
	
	private TitleDao(){}
	
	public static TitleDao getInstance() {
		return instance;
	}

	@Override
	public int insertItem(Title item) {
		sql = "insert into title values(?, ?)";
		int res=-1;
		try {
			pstmt = DBCon.getConnection().prepareStatement(sql);
			pstmt.setInt(1, item.getNo());
			pstmt.setString(2, item.getTitle());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return res;
	}

	@Override
	public int updateItem(Title item) {
		sql = "update title set titlename = ? where no=?";
		int res=-1;
		try {
			pstmt = DBCon.getConnection().prepareStatement(sql);
			pstmt.setString(1, item.getTitle());
			pstmt.setInt(2, item.getNo());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return res;
	}

	@Override
	public Title selectByItem(int idx) {
		sql = "select * from title where no=?";
		Title title = null;
		try {
			pstmt = DBCon.getConnection().prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()){
				title = new Title(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		return title;
	}

	@Override
	public List<Title> selectByAllItems() {
		List<Title> titles = new ArrayList<Title>();
		sql = "select no, titlename from title";

		try {
			pstmt = DBCon.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()){
				titles.add(new Title(rs.getInt("no"), rs.getString("titlename")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		return titles;
	}

	@Override
	public void deleteItem(int idx) {
		sql = "delete from title where no=?";
		try {
			pstmt = DBCon.getConnection().prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public int selectNextNo() {
		sql = "select Max(no) from title";
		int nextNo = -1;
		try {
			pstmt = DBCon.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()){
				nextNo = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return nextNo;
	}
	
}
