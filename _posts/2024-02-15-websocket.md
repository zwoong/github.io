---
layout: post
title: WebSocket이란
tags: [Research, WebSocket, WebSocket이란]
categories: [Research, WebSocket, WebSocket이란]
image:
  path: /assets/img/post/research/websocket.png
  alt: websocket
date: 2024-02-15 19:04 +0900
---

## 웹소켓(WebSocket)

웹소켓(WebSocket)은 실시간 통신을 위해 설계된 고급 기술로, **클라이언트와 서버 간에 양방향 통신 채널을 제공**한다. 이는 웹 애플리케이션에서 실시간으로 데이터를 교환할 수 있게 해주며, HTTP 프로토콜 위에서 작동하지만, 웹소켓 프로토콜은 별도의 프로토콜입니다. 웹소켓은 "ws" (비암호화)와 "wss" (암호화)라는 두 가지 URI를 사용한다.

### 웹소캣은 UDP와 연관있나?

> 처음 **웹소캣을 접할 때 당연히 UDP기반 위에서 동작하리라 생각**했다. <br>
> (UDP에 경우 실시간 통신에 사용한다고 알고 있었기 때문에)

웹소켓(WebSocket) 프로토콜은 **애플리케이션 계층(Application Layer)에서 동작**한다. 웹소켓은 HTTP 프로토콜을 기반으로 초기 핸드셰이크를 수행한 후, 이 **핸드셰이크 과정 후에 업그레이드된 연결을 통해 독립적인 프로토콜로서의 웹소켓 통신을 시작**한다. 이렇게 설정된 연결은 TCP(Transmission Control Protocol) 위에서 지속적인 양방향 통신을 위해 사용됩니다.

**웹소켓은 기본적으로 TCP 위에서 작동**한다. TCP는 전송 계층(Transport Layer)에 위치하며, **신뢰성 있는 데이터 전송을 보장하기 위해 연결 지향적인 특성**을 가지고 있다.

### 특징

1. **양방향 통신**: 웹소켓은 **클라이언트와 서버 간의 양방향 통신을 가능**하게 한다. 이는 서버가 클라이언트에 데이터를 푸시할 수 있음을 의미하며, 이는 실시간 웹 애플리케이션(예: 실시간 채팅, 게임, 금융 플랫폼)에 매우 유용하다.
2. **저지연**: 웹소켓은 저지연 통신을 제공한다. **연결이 한 번 수립되면, 메시지는 매우 낮은 지연 시간으로 전송**될 수 있다. 이는 고성능이 필요한 애플리케이션에 적합하다.
3. **풀듀플렉스(Full-duplex)**: 웹소켓 연결은 풀듀플렉스 통신을 지원한다. **클라이언트와 서버가 동시에 데이터를 송수신할 수 있음을 의미**한다.
4. **지속적인 연결**: 웹소켓 연결은 지속적이다. 한 번 연결이 수립되면, 연결이 명시적으로 닫힐 때까지 열려 있다.
5. **호환성**: 웹소켓은 **대부분의 최신 웹 브라우저에서 지원**된다.

### HTTP vs WebSocket

이제 HTTP와 WebSocket 통신 방식에 대해 간략히 알아보자.

- **HTTP**
  - **비연속적인 연결(Non-Persistent Connection)**: 클라이언트가 서버에 요청(request)을 보내면, 서버는 해당 요청에 대한 응답(response)을 전송하고 연결을 종료한다. **다음 요청이 있을 때마다 새로운 연결이 필요**하다.
  - **상태가 없는(Stateless)**: 각 요청은 독립적이며, 서버는 이전 요청에 대한 정보를 유지하지 않는다.
  - **요청/응답 패턴**: 클라이언트는 **서버에 정보를 요청하고, 서버는 그에 대한 응답을 한 번만 보낸다**.
- **WebSocket**
  - **지속적인 연결(Persistent Connection)**: 클라이언트는 **WebSocket 요청을 보내고, 서버가 이를 수락(accept)하면 지속적인 연결이 형성**된다. 이 연결은 명시적으로 닫힐 때까지 유지된다.
  - **양방향 통신(Bi-directional Communication)**: 연결이 수립되면, 클라이언트와 서버는 **양방향으로 데이터를 주고받을 수 있다**. 이는 클라이언트 또는 서버 측에서 언제든지 데이터를 전송할 수 있음을 의미합니다.
  - **효율적인 데이터 전송**: **연결이 한 번 수립되면, 추가적인 HTTP 헤더 없이 데이터를 전송할 수 있어 오버헤드가 줄어든다**.

![http-websocket](/assets/img/post/research/http-websocket.png){: width=＂700＂ }