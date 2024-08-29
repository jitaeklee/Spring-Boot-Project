

## 📝 API 명세서

Todo
| 기능 | Method | URL | Request | Response | 상태 코드 |

| 일정 등록 | POST | /users/{userId}/todos | RequestBody | 등록 정보 | 200 : 정상등록 |
| 일정 페이지 조회 | GET | /todos | RequestParam | 다건 응답 정보 | 200: 정상조회 |
| 일정 단건 조회 | GET | /todos/{todoId} | PathVariable | 단건 응답 정보 | 200: 정상조회 |
| 일정 수정 | PUT | /todos/{todoId} | PathVariable | 수정 정보 | 200: 정상수정 |
| 일정 삭제 | DELETE | /todos/{todoId} | PathVariable | 삭제 정보 | 200: 정상삭제 |

Comment
| 기능 | Method | URL | Request | Response | 상태 코드 |

| 댓글 등록 | POST | /todos/{todoId}/comments | RequestBody | 등록 정보 | 200 : 정상등록 |
| 댓글 전체 조회 | GET | /todos/{todoId}/comments | PathVariable | 다건 응답 정보 | 200 : 정상조회 |
| 댓글 단건 조회 | GET | /todos/comments/{commentId} | PathVariable | 단건 응답 정보 | 200 : 정상조회 |
| 댓글 수정 | PUT | /todos/comments/{commentId} | PathVariable | 수정 정보 | 200 : 정상수정 |
| 댓글 삭제 | DELETE | /todos/comments/{commentId} | PathVariable | 삭제 정보 | 200 : 정상삭제 |

User
| 기능 | Method | URL | Request | Response | 상태 코드 |

| 유저 등록 | POST | /users | RequestBody | 등록 정보 | 200 : 정상등록 |
| 유저 추가 배치 | POST | /users/todos | RequestBody | 다건 응답 정보 | 200 : 정상등록 |
| 유저 전체 조회 | GET | /users |    | 다건 응답 정보 | 200 : 정상조회 |
| 유저 단건 조회 | GET | /users/{userId} | PathVariable | 단건 응답 정보 | 200 : 정상조회 |
| 유저 수정 | PUT | /users/{userId} | PathVariable | 수정 정보 | 200 : 정상수정 |
| 유저 삭제 | DELETE | /users/{userId} | PathVariable | 삭제 정보 | 200 : 정상삭제 |

