<template>
  <div>
    <label for="isbn">ISBN : </label>
    <input type="text" v-model="book.isbn" />
    <hr />
    <label for="title">TITLE : </label>
    <input type="text" v-model="book.title" />
    <hr />
    <label for="author">AUTHOR : </label>
    <input type="text" v-model="book.author" />
    <hr />
    <button @click="createBook">CREATE</button>
    <button @click="updateBook">UPDATE</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "CreateView",
  data() {
    return {
      book: {
        isbn: "",
        title: "",
        author: "",
      },
    };
  },
  methods: {
    createBook() {
      console.log(this.book);
      axios({
        method: "post",
        url: "http://localhost:8080/bookapi/book",
        headers: {
          "Content-type": "application/json",
        },
        data: this.book,
      }).then((res) => {
        console.log(res.data);
      });
    },
    updateBook() {
      axios({
        method: "put",
        url: "http://localhost:8080/bookapi/book",
        headers: {
          "Content-type": "application/json",
        },
        data: this.book,
      }).then((res) => {
        console.log(res.data);
      });
    },
  },
};
</script>

<style></style>
