package com.java.spring_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.java.spring_crud.dto.BDto;
import com.java.spring_crud.util.Constant;

//실제 DB에 접근
public class BDao {

	DataSource dataSource;
	
	JdbcTemplate template = null;
	
	public BDao() {
		template = Constant.template;
	}
	
	public BDto contentView(String strID){	
		//upHit(strID); 조회수 올리는 쿼리 bid가 같은 녀석 히트수를 높이는과정
		String query = "select * from mvc_board where bId = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));	
	}
	
	public void write(final String bName, final String bTitle, final String bContent){
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				
				return pstmt;
			}
		});
	}
	
	public ArrayList<BDto> list() {
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from MVC_BOARD order by bGroup desc, bStep asc";
		return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void modify(final String bId, final String bName, final String bTitle, final String bContent){
		String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
		template.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,  bName);
				ps.setString(2,  bTitle);
				ps.setString(3,  bContent);			
				ps.setInt(4,  Integer.parseInt(bId));	
			}
			
		});
	}
	
	public void delete(final String bId){
		String query = "delete from mvc_board where bId = ?";
		
		template.update(query, new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));	
			}
		});
	}
	
	public BDto reply_view(String strId){
		String query = "select * from mvc_board where bId = " + strId;	
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void reply(final String bId, final String bName, final String bTitle, final String bContent, final String bGroup, final String bStep, final String bIndent){
		String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		template.update(query, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep) + 1);
				ps.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		});
	}
	
	private void replyShape(final String strGroup, final String strStep) {
		String query = "update mvc_board set bStep = bStep + 1 where bGroup = " + strGroup + " and bStep > " + strStep;
		template.update(query, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,  Integer.parseInt(strGroup));
				ps.setInt(2,  Integer.parseInt(strStep));	
			}
		});
	}
}
