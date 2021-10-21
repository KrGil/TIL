# [javascript] Uncaught TypeError: Cannot read properties of undefined (reading 'classList')  modal.js:313 

### 버전

Bootstrap 5.13



### Error

> modal에 값을 전달하기 위해 script로 .modal("show")를 사용하여 변환하는 과정에서 오류가 생겼습니다.

```
modal.js:313 Uncaught TypeError: Cannot read properties of undefined (reading 'classList')
    at he._isAnimated (modal.js:313)
    at he._initializeBackDrop (modal.js:195)
    at new he (modal.js:83)
    at Function.getOrCreateInstance (base-component.js:55)
    at HTMLButtonElement.<anonymous> (modal.js:421)
    at HTMLDocument.s (event-handler.js:119)
```



### code

```
<button type="button" class="btn btn-primary restBtn" data-bs-toggle="modal" data-method="POST">

<div class="modal fade" id="memberRestModal" tabindex="-1" aria-labelledby="newMemberModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="newMemberModalLabel">New message</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form class="row g-3" id="newMemberInfo-Form">
					<div class="col-md-6">
						<label for="id" class="col-form-label">Id:</label>
						<input type="text" name="userId" class="form-control" id="id">
					</div>
					<div class="col-md-6">
						<label for="name" class="col-form-label">Name:</label>
						<input type="text" name="userName" class="form-control" id="name">
					</div>
					<div class="mb-3">
						<label for="pass" class="col-form-label">Password:</label>
						<input type="text" name="userPass" class="form-control" id="pass">
					</div>

					<div class="mb-3">
						<label for="confirm-pass" class="col-form-label">Confirm Password:</label>
						<input type="text" class="form-control" id="confirm-pass">
					</div>
					<fieldset class="row mb-3">
						<legend class="col-form-label col-sm-2 pt-0">IsAdmin</legend>
						<div class="col-sm-10">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="isAdmin" id="isAdminY" value="1" >
								<label class="form-check-label" for="isAdminY">
									yes
								</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="isAdmin" id="isAdminN" value="0" checked>
								<label class="form-check-label" for="isAdminN">
									no
								</label>
							</div>
						</div>
					</fieldset>

				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary" id="addNewMemberBtn" data-path="member" data-method="POST">Add</button>
				</div>
			</div>
		</div>
	</div>
</div>
```

#### script

```
$("#content-body").on("click", ".restBtn", function (){
			let method = $(this).data("method");
			$("#addNewMemberBtn").data("method", method);
			console.log($("#addNewMemberBtn").data("method"));
			$("#memberRestModal").modal("show");
		})
```

기능상 아무런 이상도 없지만 개발자 도구로 확인 시 버튼 클릭마다 error가 발생.



### Reason

```<button>``` 태그에 ```data-bs-toggle```을 지워주니 해결됬습니다. ```data-bs-``` 관련 속성들은 script 없이 창을 띄울 때 사용하는 속성인 듯 합니다.

그러니 javascript로 변환 시 ```data-bs-``` 속성은 삭제 후 처리해 주시면 error가 발생하지 않습니다.



