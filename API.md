## API
### 로그인 
- POST /login
- BODY :
```
{
    id : id
    pw : pw
}
```


### 회원가입
- POST /users
- BODY : User Object


### 회원 탈퇴
- DELETE /users/:id
- request param : userId


### 닉네임 수정
- PATCH /users/:id
- request param : userId
- BODY : 
```
{
    nickName : nickName
}
```

### 게시판 목록 조회
- GET /posts
- Response : Post Object Array


### 게시판 생성
- POST /posts
- BODY : Post Object
- status : 200

### 게시판 상세조회
- GET /posts/:id
- request param : postId
- Resposne : Post Object


### 댓글 추가
- POST /posts/:id/comments
- request param : postId 
- BODY: Comment Object


## Object
### User
```
{
    id : String,
    pw : String,
    nickName : String
}
```

### Comment
```
{
    id: Long,
    content : String
    date : Date,
    owner : User Object
}
```

### Post
```
 {
    id: Long,
    title: String,
    city: City Enum, 
    sportsTypes: SportsType Enum, 
    content: String,
    date: Date,
    recruit: boolean,
    likeCount: int,
    owner: User Object,
    comments: Comment Object Array
}
```

