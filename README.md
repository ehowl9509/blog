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

    - 회원가입, 게시판 글쓰기 JpaRepository.save사용
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
    - 페이징 처리
    ~~~
   public PageMaker generatePageMaker(int pageNum, int contentNum, JpaRepository<Freeboard, Long> repository) {

        PageMaker pageMaker = new PageMaker();
        int totalCount = (int) repository.count();
        pageMaker.setTotalcount(totalCount); // 전체 게시글 수를 지정한다.
        pageMaker.setPagenum(pageNum - 1); // 현재 페이지를 페이지 객체에 지정한다. -1을 해야 쿼리에서 사용 할 수 있다.
        pageMaker.setContentnum(contentNum);// 한 페이지에 몇개씩 게시글을 보여줄지 지정한다.
        pageMaker.setCurrentblock(pageNum);// 현재 페이지 블록이 몇 번인지 현재 페이지 번호를 통해서 지정한다.
        pageMaker.setLastblock(pageMaker.getTotalcount());//마지막 블록 번호를 전체 게시글 수를 통해서 정한다.
        pageMaker.prevnext(pageNum); // 현재 페이지 번호로 화살표를 나타낼지 정한다.
        pageMaker.setStartPage(pageMaker.getCurrentblock()); // 시작 페이지를 페이지 블록 번호로 정한다.
        pageMaker.setEndPage(pageMaker.getLastblock(), pageMaker.getCurrentblock()); // 마지막 페이지를 마지막 페이지 블록과 현재 페이지                                     블록 번호로 정한다

        return pageMaker;
    ~~~

    - 게시판 리스트 설정
    ~~~
        PageMaker pageMaker = pageMakerService.generatePageMaker(pageNum, 9, freeboardRepository);

        PageRequest pageRequest = PageRequest.of(pageNum-1, 9, Sort.Direction.DESC, "freeId");
        Page<Freeboard> freeboardPage = freeboardRepository.findAll(pageRequest);
        if (freeboardPage.getSize() == 0 ){
            session.setAttribute("boardList", new ArrayList<Freeboard>());
            session.setAttribute("pageMaker", pageMaker);
#### Flont(view)
- Bootstrap
- Thymeleaf
    - 로그인 상태에 따른 로그아웃 유무
    ~~~
         <li th:if="${session.loginUser == null}"><a href="/joinPage"><span class="glyphicon glyphicon-log-in"></span> 회원가입 </a></li>
         <li th:if="${session.loginUser == null}"><a href="/loginPage"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
         <li th:if="${session.loginUser != null}"><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> 로그아웃</a></li>
           


#### SKILL
- Spring boot

- JPA

- MYSQL

- Thymeleaf
#### Tool
- Intelli J
