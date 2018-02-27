package io.manco.task.core.service;


public class EntityServiceIntegrationTest{//} extends ContextAwareTest {

//	@Autowired
//	private EntityService service;
//
//	@Test
//	@Rollback
//	@Transactional(readOnly = false)
//	public void save() {
//		MyEntity entity = new MyEntity("test", "test");
//		assertThat(entity.getId(), nullValue());
//		entity = service.save(entity);
//		assertThat(entity.getId(), notNullValue());
//	}
//
//	@Test
//	@Rollback
//	@Transactional(readOnly = false)
//	public void find() {
//		MyEntity entity = service.save(new MyEntity("test", "test"));
//		entity = service.find(entity.getId());
//		assertThat(entity, notNullValue());
//	}
//
//	@Test
//	@Rollback
//	@Transactional(readOnly = false)
//	public void findAll() {
//		Collection<MyEntity> entities = new ArrayList<>();
//		entities.add(service.save(new MyEntity("test", "test")));
//		entities.add(service.save(new MyEntity("test2", "test")));
//		entities.add(service.save(new MyEntity("test3", "test")));
//		Collection<MyEntity> all = service.findAll();
//		assertThat(all, equalTo(entities));
//	}
	
}
