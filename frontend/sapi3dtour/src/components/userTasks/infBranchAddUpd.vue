<template>
    <v-card id="card" width="550" class="mx-3 my-3">
        <v-card-title> Szak megadása </v-card-title>
        <v-divider class="mx-5 my-3"></v-divider>
        <v-radio-group class="mx-5 " v-model="selectResult" row>
            <v-radio label="Hozzáadás" value="add"></v-radio>
            <v-radio label="Szerkesztés" value="update"></v-radio>
        </v-radio-group>
        <InfBarnchAdd v-if="this.selectResult == 'add' "/>
        <!-- <InfDepUpd v-if="this.selectResult == 'update' "/> -->
    </v-card>
</template>

<script>

import InfBarnchAdd from "./infBranchAdd.vue";
// import InfDepUpd from "./InfDepUpd.vue";

export default {
    name: 'InformationBranchAddUpdate',
    components:{InfBarnchAdd},
    data () {
        return {
            selectResult: "add",
        };
    },
    methods:{
        
    },
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
</style>