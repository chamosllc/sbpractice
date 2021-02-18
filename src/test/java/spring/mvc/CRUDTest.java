package spring.mvc;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

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
		Date attribute = Date.valueOf("2020-04-01");
		Entity entity = new Entity(key, attribute);
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
		attribute = Date.valueOf("2021-04-01");
		entity.setAttribute(attribute);
		entityRepo.save(entity);
		Assert.isTrue(entityRepo.findById(entity.getKey()).get().getAttribute().equals(attribute), "Entity UPDATED");

		/*
		 * DELETEテスト
		 */
		entityRepo.delete(entity);
		Assert.isNull(entityRepo.findById(entity.getKey()).orElse(null), "Entity DELETED");
	}
}
