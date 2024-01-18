---
layout: post
title: Git 사용자 인증
tags: [Git, Git 사용자 인증]
categories: [Git, Git 사용자 인증]
image:
  path: /assets/img/post/git/git-authentication.png
  alt: git-authentication
date: 2024-01-18 22:19 +0900
---

> 지난 시간까지는 Git을 설치하고 커밋 추적을 위해 사용자 설정까지 하는 방법을 알아봤다. <br>
> 오늘은 Git에서 저장소를 복제하고 SSH 키 또는 개인 액세스 토큰을 사용하여 인증하는 방식에 대해 각각 알아보자. 😉

## SSH 키 인증을 사용한 복제

- **SSH 키 쌍을 생성한다.** <br>
  먼저 로컬 시스템에 SSH 키 쌍을 생성해야 한다.

```console
ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```

위 명령어를 통해 제공된 이메일을 사용하여 새 SSH 키가 생성되며, "키를 저장할 파일을 입력하세요"라는 메시지가 나타나면 Enter 키를 눌러 기본 위치에 저장한다.

- **SSH-에이전트에 SSH 키를 추가한다.** <br>
  백그라운드에서 ssh-agent를 시작하고 SSH 개인 키를 ssh-agent에 추가한다.

```console
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_rsa
```

- **Git 계정에 SSH 공개 키를 추가한다.** <br>

```console
cat ~/.ssh/id_rsa.pub
```

Git 계정 설정으로 이동하여 SSH 키 설정을 찾아 Title에 원하는 이름을 지어주고 공개 키를 붙여넣는다.

![git-access-token-registration](/assets/img/post/git/git-access-token-registration.png){: width=＂700＂ }

![git-access-token-registration-detail](/assets/img/post/git/git-access-token-registration-detail.png){: width=＂700＂ }

- **리포지토리를 복제한다.** <br>
  이제 SSH를 사용하여 저장소를 복제할 수 있으며, 저장소의 SSH URL을 가져오고 다음을 실행한다.

```console
git clone git@github.com:username/repo.git
```

## 개인 액세스 토큰(PAT)을 사용한 복제

- **Git에서 개인 액세스 토큰을 생성한다.**

  - Git 플랫폼(GitHub, GitLab 등)에서 계정 설정으로 이동한다.
  - 개발자 설정에 개인 액세스 토큰 섹션을 찾는다.
  - 적절한 범위(권한)를 사용하여 새 토큰을 생성한다. 저장소를 복제하려면 일반적으로 저장소에 대한 읽기 액세스 권한이 필요하다.

![git-pat-generate](/assets/img/post/git/git-pat-generate.png){: width=＂700＂ }

> **생성된 토큰을 복사하여 안전하게 보관하고 절대 노출시키면 안된다**. 토큰은 로그인할때 사용하는 비밀번호와 같다.❗️

- **리포지토리를 복제한다.** <br>
  'your_username'을 실제 사용자 이름으로 바꾸고, 'your_token'을 개인 액세스 토큰으로, 'git_repo_url'을 저장소의 HTTPS URL로 바꾸면 된다.

```console
git clone https://your_username:your_token@git_repo_url
```
