import Api from './Api'
import authHeader from './AuthHeader';

export default{
    
    getUser: (id) => {
        let page = 'user/returnAdmin?id=' + String(id);
        return Api().get(page, { headers: authHeader() });
    },
    loginVerification: (user) => {
        let page = 'user/authenticate';
        return Api().post(page, user);
    },
    registerUser: (user) => {
        let page = 'user/registration';
        return Api().post(page, user, { headers: authHeader() });
    },
    addPassword: (password) => {
        let page = 'user/password';
        return Api().post(page, password);
    }
    
}