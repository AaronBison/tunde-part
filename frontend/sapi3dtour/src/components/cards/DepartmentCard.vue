<template>
    <v-card id="card" class="mx-3 my-3" elevation="10" >
        <v-card-title class="justify-center"> {{ card.departmentName }} </v-card-title>
        <v-divider class="mx-5 my-3"></v-divider>
        <v-row class="justify-center">
            <v-col>
                <v-list-item center class="mx-5">
                    <v-list-item-icon>
                        <v-icon> fas fa-envelope </v-icon>
                    </v-list-item-icon>
                    <v-list-item-content>
                        <v-list-item-title v-text="card.emailAddress"></v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-col>
            <v-col>
                <v-list-item center class="mx-5">
                    <v-list-item-icon>
                        <v-icon> fas fa-phone-square-alt </v-icon>
                    </v-list-item-icon>
                    <v-list-item-content>
                        <v-list-item-title v-text="card.phoneNumber"></v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-col>
            <v-col>
                <v-list-item center class="mx-5">
                    <v-list-item-icon>
                        <v-icon> fas fa-home </v-icon>
                    </v-list-item-icon>
                    <v-list-item-content>
                        <v-list-item-title>{{card.roomNumber}} terem</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-col>
        </v-row>
        <v-row class="justify-center">
            <v-col>
                <v-list-item center class="mx-5">
                    <v-list-item-icon>
                        <v-icon> fas fa-info-circle </v-icon>
                    </v-list-item-icon>
                    <v-list-item-content>
                        <v-list-item-title>
                            Leírás&nbsp;&nbsp;&nbsp;
                            <v-btn icon @click="show = !show">
                                <v-icon>{{ show ? '' : 'fas fa-chevron-circle-down' }}</v-icon>
                            </v-btn>
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-col>
            <v-col>
                <v-list-item center class="mx-5">
                    <v-list-item-icon>
                        <v-icon> fas fa-chalkboard-teacher </v-icon>
                    </v-list-item-icon>
                    <v-btn outlined text class="mr-4">Alrészlegek</v-btn>
                </v-list-item>
            </v-col>
        </v-row>
        <v-row v-show="show" class="justify-center">
            <v-col>
                <v-list-item center class="mx-5">
                    <v-list-item-content >
                        <v-list-item-title >
                            {{ card.description }}
                            <v-btn icon @click="show = !show">
                                <v-icon>{{ show ? 'fas fa-chevron-circle-up' : '' }}</v-icon>
                            </v-btn>
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-col>
        </v-row>
    </v-card>
</template>

<script>

export default {
    name: 'DepartmentCard',
    props: ["card"],
    data () {
        return {
            show: false,
        };
    }
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
</style>