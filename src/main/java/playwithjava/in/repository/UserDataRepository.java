package playwithjava.in.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import playwithjava.in.entity.UserDataEntity;

@Repository
public interface UserDataRepository extends MongoRepository<UserDataEntity,Long> {
}
