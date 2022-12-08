package com.example.kickerdavinci.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.kickerdavinci.AuthenticationProperties;
import com.example.kickerdavinci.Models.model.Credentials;
import com.example.kickerdavinci.Models.model.NoIdUser;
import com.example.kickerdavinci.Models.User;
import com.example.kickerdavinci.Repository.UsersRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UsersRepository usersRepository;

  private final Algorithm jwtAlgorithm;
  private final JWTVerifier jwtVerifier;

  public UserService(UsersRepository usersRepository,
      AuthenticationProperties properties) {
    this.usersRepository = usersRepository;
    this.jwtAlgorithm = Algorithm.HMAC512(properties.getSecret());
    this.jwtVerifier = JWT.require(this.jwtAlgorithm).withIssuer("auth0").build();
  }

  public boolean createOne(NoIdUser user) {

    if (usersRepository.existsByEmail(user.getEmail())) {
      return false;
    }
    user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
    usersRepository.save(user.toUser());
    //usersRepository.deleteAll();
    return true;
  }

  public String connect(Credentials credentials) {
    User user = usersRepository.findByEmail(credentials.getEmail());
    if (user == null) {
      return null;
    }
    if (!BCrypt.checkpw(credentials.getPassword(), user.getPassword())) {
      return null;
    }
    return JWT.create().withIssuer("auth0").withClaim("pseudo", user.getEmail())
        .sign(this.jwtAlgorithm);
  }

  public boolean existsEmail(String email) {
    return usersRepository.existsByEmail(email);
  }

  public boolean update(User user, String email) {
    if (usersRepository.existsByEmail(user.getEmail())) {
      return false;
    }
    User userDb = usersRepository.findByEmail(email);
    user.setId(userDb.getId());
    user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
    usersRepository.save(user);
    return true;
  }
}
