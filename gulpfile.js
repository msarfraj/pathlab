var gulp = require('gulp'), 
    watch = require('gulp-watch');
    

gulp.task('watch', function () {
    return watch('src/main/resources/static/**/*.*', () => {
            gulp.src('src/main/resources/static/**')
                //replace with build/resources/main/ for netBeans
                .pipe(gulp.dest('target/classes/static/')); 
    });
});

gulp.task('default', gulp.series(['watch']));