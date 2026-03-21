package project.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import project.domain.entity.Project;
import project.repository.entity.ProjectEntity;
import project.repository.entity.TaskEntity;

@QuarkusTest
public class ProjectRepositoryTest {

    @Inject
    ProjectRepository projectRepository;

    @Test
    @TestTransaction
    void userIdのみでフィルタリングする場合() {
        // テストデータのクリーンアップ
        TaskEntity.deleteAll();
        ProjectEntity.deleteAll();

        // テストデータの作成
        ProjectEntity project1 = ProjectEntity.builder()
                .userId(1L)
                .title("Project A")
                .registerDate("2023-01-01")
                .build();
        project1.persist();

        ProjectEntity project2 = ProjectEntity.builder()
                .userId(2L)
                .title("Project B")
                .registerDate("2023-01-02")
                .build();
        project2.persist();

        TaskEntity task1 = TaskEntity.builder()
                .project(project1)
                .parentProjectId(project1.getProjectId())
                .taskName("Task 1")
                .status("0")
                .build();
        task1.persist();

        // メソッド実行
        List<Project> result = projectRepository.list(1L, null);

        // アサーション
        assertEquals(1, result.size());
        assertEquals("Project A", result.get(0).getTitle());
        assertEquals(1, result.get(0).getTaskList().size());
        assertEquals("Task 1", result.get(0).getTaskList().get(0).getTaskName());
    }

    @Test
    @TestTransaction
    void userIdとtitleでフィルタリングする場合() {
        // テストデータのクリーンアップ
        TaskEntity.deleteAll();
        ProjectEntity.deleteAll();

        // テストデータの作成
        ProjectEntity project1 = ProjectEntity.builder()
                .userId(1L)
                .title("Project A")
                .registerDate("2023-01-01")
                .build();
        project1.persist();

        ProjectEntity project2 = ProjectEntity.builder()
                .userId(1L)
                .title("Another Project")
                .registerDate("2023-01-02")
                .build();
        project2.persist();

        // メソッド実行
        List<Project> result = projectRepository.list(1L, "Project");

        // アサーション
        assertEquals(2, result.size());
        assertEquals("Project A", result.get(0).getTitle());
    }

    @Test
    @TestTransaction
    void 該当するプロジェクトがない場合() {
        // テストデータのクリーンアップ
        TaskEntity.deleteAll();
        ProjectEntity.deleteAll();

        // メソッド実行
        List<Project> result = projectRepository.list(999L, null);

        // アサーション
        assertTrue(result.isEmpty());
    }
}
