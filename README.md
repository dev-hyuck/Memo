## 💡 주요 기능

| 기능 | 설명 |
|------|------|
| **Create** | 사용자가 입력한 메모를 DB에 저장 |
| **Read (Get)** | 저장된 모든 메모를 리스트 형태로 조회 |
| **Update** | 특정 메모 ID를 기준으로 내용 수정 |
| **Delete** | 특정 메모 삭제 |
| **BaseEntity** | `createdAt`, `modifiedAt` 자동 관리 (상속 구조) |



## 🧩 기술 포인트
- **3 Layer Architecture**  
  Controller → Service → Repository 구조로 역할 분리  
- **DTO 패턴 적용**  
  Entity와 View(Data) 분리로 유지보수성 향상  
- **JPA 활용**  
  `@Entity`, `@Id`, `@GeneratedValue`, `@Transactional` 사용  
- **Lombok 사용**  
  `@RequiredArgsConstructor`, `@Getter`, `@NoArgsConstructor` 로 보일러플레이트 최소화  
- **MySQL 연동**  
  `application.yml` 설정을 통해 DB 연결 및 자동 테이블 생성

 Spring Boot에서 JPA 사용 시, import 문 하나(@Id)만 잘못돼도 Entity 인식이 안 되는 문제를 직접 겪음

DTO 패턴을 통해 Entity와 Controller 간 결합도를 낮추는 방법 학습

3 Layer 구조의 역할 구분 (Controller → Service → Repository)을 직접 구현하면서 구조적 이해 향상

@Transactional의 동작 원리 및 영속성 컨텍스트 개념을 익힘
