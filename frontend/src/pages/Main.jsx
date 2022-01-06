import { useState } from 'react';
import '../styles/Main.css';

export default function Main() {
  const [isLogin, setIsLogin] = useState(false);

  const onChange = () => setIsLogin(!isLogin);

  return (
    <div className="container">
      <div className="side-1">
        <div className="item color-1">notice</div>
        <div className="item color-2">
          <div className="contents">
            <form action="/userlogin" method="post">
              <div className="content-1">
                <div className="labels">
                  <label id="label_id" htmlFor="userID">
                    ID
                  </label>
                  <label id="label_pw" htmlFor="userPW">
                    PW
                  </label>
                </div>
                <div className="forms">
                  <input id="userID" type="text" />
                  <input id="userPW" type="password" />
                </div>
              </div>
              <div className="content-2">
                {isLogin ? (
                  <button type="submit" onClick={onChange}>
                    Logout
                  </button>
                ) : (
                  <button type="submit" onClick={onChange}>
                    Login
                  </button>
                )}
              </div>
            </form>
          </div>
        </div>
      </div>
      <div className="side-2">
        <div className="item color-3">script 1</div>
        <div className="item color-4">script 2</div>
      </div>
    </div>
  );
}
