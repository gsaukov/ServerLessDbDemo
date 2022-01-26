'use strict';
const AWS = require('aws-sdk');
const s3 = new AWS.S3({ apiVersion: '2006-03-01' });
const Logr = require('logr');
const log = new Logr({
  defaultTags: ['s3'],
  type: 'json'
});

class S3 {
  constructor(bucket, region) {
    this.bucket = bucket;
  }

  writeObject(key, data, done) {
    s3.putObject({
      Bucket: this.bucket,
      Key: key,
      Body: data
    }, done);
  }

  listObjects(prefix, done) {
    const query = {
      Bucket: this.bucket
    };
    if (prefix) {
      query.Prefix = prefix;
    }
    s3.listObjects(query, done);
  }

  getObject(key, done) {
    s3.getObject({
      Bucket: this.bucket,
      Key: key
    }, done);
  }

  loadTextObject(key, done) {
    this.getObject(key, (err, data) => {
      if (err) {
        return done(err);
      }
      done(null, data.Body.toString());
    });
  }
}

module.exports = S3;
