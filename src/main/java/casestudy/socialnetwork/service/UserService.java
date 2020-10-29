package casestudy.socialnetwork.service;


import casestudy.socialnetwork.model.User;

public interface UserService {
    User save(User user);
    User findById(Long id);
    Iterable<User> findAll();
}
