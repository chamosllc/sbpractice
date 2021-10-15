package spring.mvc.data;


import java.sql.Date;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @version 1.0.0
 * @since 2020/7/12
 * @author mashiro@chamos.biz
 */
@javax.persistence.Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entity implements java.io.Serializable {
	/** キー */
	@Id
//	@Column(name="`key`")
	protected int key;
	/** 値 */
	protected Date value;
}
