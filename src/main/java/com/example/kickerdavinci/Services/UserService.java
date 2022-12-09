package com.example.kickerdavinci.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.kickerdavinci.AuthenticationProperties;
import com.example.kickerdavinci.Models.Credentials;
import com.example.kickerdavinci.Models.NoIdUser;
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


  public boolean createUser(NoIdUser user) {
    boolean created = createOne(user);
    return created;

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
    return JWT.create().withIssuer("auth0").withClaim("email", user.getEmail())
        .sign(this.jwtAlgorithm);
  }
}
