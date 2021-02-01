import Api from './Api'
import authHeader from './AuthHeader';

export default{
    getDepartments: async() => {
        let page = 'api/department/getDepartments';
        return Api().get(page);
    },
    getBranches: async(department) => {
        let page = '/api/branch/getBranchByDepartment';
        return Api().post(page, department);
    },
    getOtherBranches: async(department) => {
        let page = '/api/othersBranch/getOthersBranchByDepartment';
        return Api().post(page, department);
    }
} 