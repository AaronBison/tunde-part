import Api from './Api'
import authHeader from './AuthHeader';

export default{
    getDepartments: async() => {
        let page = 'api/department/getDepartments';
        return Api().get(page);
    },
}