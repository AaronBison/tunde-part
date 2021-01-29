<template>
    <v-container class="justify-center">
        <div v-for="(textField, i) in textFields" :key="i" class="text-fields-row">
            <v-text-field class="mx-2" v-model="textField.value1" :label="textField.label1" outlined clearable></v-text-field>
            <v-text-field class="mx-2" v-model="textField.value2" :label="textField.label2" outlined clearable></v-text-field>
            <!-- <v-text-field :label="textField.label1" v-model="textField.value1"></v-text-field>
            <v-text-field :label="textField.label2" v-model="textField.value2"></v-text-field> -->
            <v-btn icon @click="remove(i)">
                <v-icon> far fa-trash-alt </v-icon>
            </v-btn>
        </div>
        <v-btn icon @click="add">
            <v-icon> fas fa-plus </v-icon>
        </v-btn>
    </v-container>
</template>

<script>
import UserTasks from "@/services/userTasks";

export default {
    name: 'InformationOthersAdd',
    data () {
        return {
            textFields: []
        };
    },
    methods:{
        add () {
            this.textFields.push({ 
                label1: "Elem elnevezése (pl. név, email stb.)", 
                value1: "",
                label2: "Maga az elem (pl. Kiss Attila)",
                value2: ""
            })
        },
        remove (index) {
            this.textFields.splice(index, 1)
        }
    },
    mounted() {
        this.add();
    },
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
    .text-fields-row {
        display: flex;
    }
</style>