# 로그인과 게시판 구현

#### Function
- 회원가입, 로그인 

- 게시판, 게시판 페이징 구현
    - 로그인 상태 게시판 구현 가능

#### Directory structure

<img width="391" alt="direc" src="https://user-images.githubusercontent.com/48824988/64904008-1db5c600-d6fe-11e9-86be-5be9b1750ca0.png">


- controller
    - 게시판, 회원가입, 로그인 등 controller부문
- model
    - Entity 부분 
- pageMaker
    - 게시판 페이징 관리 
- repository
    - 각Entity JpaRepository 모음
- service 
    - 회원가입
    ~~~
  Users users = new Users();                        
  users.setUserid(userId);                      
  users.setUserpw(userPw);                      
  users.setUsername(userName);                      
  userRepository.save(users);
  
  Freeboard freeboard = new Freeboard();
  freeboard.setTitle(title);
  freeboard.setContent(content);
  freeboard.setWriter(writer);
  freeboardRepository.save(freeboard);
     ~~~

#### DB TABLE
- User

- Freeboard



#### SKILL
- Spring boot

- JPA

- MYSQL

- Thymeleaf
#### Tool
- Intelli J
