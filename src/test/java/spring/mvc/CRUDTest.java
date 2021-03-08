package spring.mvc;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import spring.mvc.data.Entity;
import spring.mvc.data.EntityRepository;

/**
 * テスト:CRUD) Entityデータベース
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CRUDTest {
	@Autowired
	protected EntityRepository entityRepo;

	/**
	 * Entity CRUDテスト
	 */
	@Test
	void entityTest() {
		/*
		 * テスト用エンティティ
		 */
		int key = 1;
		Date value = Date.valueOf("2020-04-01");
		Entity entity = new Entity(key, value);
		/*
		 * CREATEテスト
		 */
		entityRepo.save(entity);

		/*
		 * READテスト
		 */
		Assert.isTrue((entityRepo.findById(entity.getKey())).isPresent(), "Entity READ ONE");
		Assert.isTrue(!entityRepo.findAll().isEmpty(), "Entity READ ALL");

		/*
		 * UPDATEテスト
		 */
		value = Date.valueOf("2021-04-01");
		entity.setValue(value);
		entityRepo.save(entity);
		Assert.isTrue(entityRepo.findById(entity.getKey()).get().getValue().equals(value), "Entity UPDATED");

		/*
		 * DELETEテスト
		 */
		entityRepo.delete(entity);
		Assert.isNull(entityRepo.findById(entity.getKey()).orElse(null), "Entity DELETED");
	}
}
