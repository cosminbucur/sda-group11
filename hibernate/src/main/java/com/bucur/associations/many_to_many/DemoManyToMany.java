package com.bucur.associations.many_to_many;

public class DemoManyToMany {

    public static void main(String[] args) {
        // create 2 tags
        Tag tag1 = new Tag();
        tag1.setName("tag1");

        Tag tag2 = new Tag();
        tag2.setName("tag2");

        // create 2 posts
        Post post1 = new Post();
        post1.setTitle("post1");

        Post post2 = new Post();
        post2.setTitle("post2");

        // add 2 tags to post 1
        post1.addTag(tag1);
        post1.addTag(tag2);

        // add 2 tags to post 2
        post2.addTag(tag2);

        // persist
        PostDao postDao = new PostDao();
        postDao.create(post1);
        postDao.create(post2);
    }
}
